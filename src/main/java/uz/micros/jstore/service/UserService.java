package uz.micros.jstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.micros.jstore.entity.AppUser;
import uz.micros.jstore.repository.UserRepository;
import uz.micros.jstore.service.exception.ServiceException;
import uz.micros.jstore.service.exception.UsernameAlreadyInUseException;

import javax.persistence.PersistenceException;

@Service
public class UserService {

    @Autowired
    private UserRepository rpstr;

    @Transactional(readOnly = true)
    public AppUser getUserByUserName(String username) {
        return rpstr.getUserByUserName(username);
    }

    @Transactional(readOnly = false, rollbackFor = ServiceException.class)
    public AppUser addUser(AppUser user) throws ServiceException {
        try{
            return rpstr.saveAndFlush(user);
        }
        catch(DuplicateKeyException e){
            throw new UsernameAlreadyInUseException(user.getUsername());
        }
        catch(PersistenceException e){
            throw new ServiceException(e);
        }
    }
}