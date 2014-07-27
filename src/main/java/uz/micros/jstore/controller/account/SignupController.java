package uz.micros.jstore.controller.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import uz.micros.jstore.dto.Message;
import uz.micros.jstore.dto.MessageType;
import uz.micros.jstore.dto.RegUserDto;
import uz.micros.jstore.entity.AppUser;
import uz.micros.jstore.security.SignInUtils;
import uz.micros.jstore.service.UserService;
import uz.micros.jstore.service.exception.ServiceException;
import uz.micros.jstore.service.exception.UsernameAlreadyInUseException;

import javax.validation.Valid;

@Controller
public class SignupController {

    @Autowired
    private UserService userService;

    private ProviderSignInUtils providerSignInUtils = new ProviderSignInUtils();

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView signupForm(WebRequest request) {
        Connection<?> connection = providerSignInUtils.getConnectionFromSession(request);
        if (connection != null) {
            //request.setAttribute("message", new Message(MessageType.INFO, "Your " + StringUtils.capitalize(connection.getKey().getProviderId()) + " account is not associated with a Spring Social Showcase account. If you're new, please sign up."), WebRequest.SCOPE_REQUEST);
            UserProfile profile = connection.fetchUserProfile();
            RegUserDto dto = new RegUserDto();
            dto.setFirstName(profile.getFirstName());
            dto.setLastName(profile.getLastName());
            dto.setUserName(profile.getUsername());

            return new ModelAndView("account/signup")
                    .addObject("newUser", dto)
                    .addObject("message", new Message(MessageType.INFO, "Your " + StringUtils.capitalize(connection.getKey().getProviderId()) + " account is not associated with a Spring Social Showcase account. If you're new, please sign up."));
        } else {
            return new ModelAndView("account/signup")
                    .addObject("newUser", new RegUserDto());
        }
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ModelAndView registerPost(@Valid @ModelAttribute("newUser") RegUserDto dto,
                                     BindingResult binding,
                                     WebRequest request) throws ServiceException {

        if (binding.hasErrors()) {
            return new ModelAndView("account/signup")
                    .addObject("newUser", dto);
        }

        if (dto.getPassword().equals(dto.getPassword2())) {

            try {
                userService.addUser(new AppUser(dto.getFirstName(),
                        dto.getLastName(),
                        dto.getUserName(),
                        dto.getPassword(), dto.getEmail(), AppUser.ROLE_USER));
                SignInUtils.signin(dto.getUserName());
                providerSignInUtils.doPostSignUp(dto.getUserName(), request);
            } catch (UsernameAlreadyInUseException ex) {
                binding.rejectValue("username", "user.duplicateUsername", "already in use");
                return null;
            }
            return new ModelAndView("redirect:/");
        } else {
            binding.rejectValue("password2", "", "Password confirmation mismatch");
            return new ModelAndView("account/signup")
                    .addObject("newUser", dto);
        }
    }
}