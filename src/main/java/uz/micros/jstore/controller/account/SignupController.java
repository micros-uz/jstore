package uz.micros.jstore.controller.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
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

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView signupForm(WebRequest request) {
        return new ModelAndView("account/signup")
                .addObject("newUser", new RegUserDto());
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ModelAndView registerPost(@Valid @ModelAttribute("newUser") RegUserDto dto,
                                     BindingResult binding) throws ServiceException {

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