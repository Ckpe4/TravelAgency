package org.lv326java.two.travelagency.services;


import org.lv326java.two.travelagency.dao.CountryDao;
import org.lv326java.two.travelagency.dao.RoleDao;
import org.lv326java.two.travelagency.dao.UserDao;
import org.lv326java.two.travelagency.dao.VisaDao;
import org.lv326java.two.travelagency.dto.RegistrationDto;
import org.lv326java.two.travelagency.dto.UserDto;
import org.lv326java.two.travelagency.dto.LoginDto;
import org.lv326java.two.travelagency.entities.Country;
import org.lv326java.two.travelagency.entities.User;
import org.lv326java.two.travelagency.entities.Visa;

import java.util.ArrayList;
import java.util.List;

public class UserService {


    private UserDao userDao;
    private RoleDao roleDao;
    private VisaDao visaDao;
    private CountryDao countryDao;



//    private UserService() {
//    }

//    private static UserService instance;
//
//    public static UserService getInstance() {
//        if (instance == null) {
//            instance = new UserService();
//        }
//        return instance;
//    }


	public UserService() {
		userDao = new UserDao();
		roleDao = new RoleDao();
		visaDao = new VisaDao();
        countryDao = new CountryDao();
	}

	private UserService(UserDao userDao, RoleDao roleDao, VisaDao visaDao, CountryDao countryDao) {
		this.userDao = userDao;
		this.roleDao = roleDao;
		this.visaDao = visaDao;
		this.countryDao = countryDao;
	}

    public boolean setUserDto(UserDto userDto) {
        boolean result = true;
        User user = userDao.getUserEntityByLogin(userDto.getLogin());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(userDto.getPassword());
        try {
            user.setRoleId(roleDao.getRoleEntityByName(userDto.getRole()).getId());
            userDao.updateByEntity(user);
        } catch (Exception e) {
            // Logging Exception
            System.out.println("RuntimeException, message: " + e.getMessage());
            result = false;
        }
        return result;
    }

    public UserDto getUserDto(LoginDto loginDto) {
        User user = userDao.getUserEntityByLogin(loginDto.getLogin());
        return new UserDto(user.getLogin(),
                user.getPassword(),
                user.getFirstName(),
                user.getLastName(),
                roleDao.getById(user.getRoleId()).getName());
    }

    public Long getRoleDao(LoginDto loginDto) {
        User user = null;
        user = userDao.getUserEntityByLogin(loginDto.getLogin());
        return user.getRoleId();
    }

    public Long getIdUserByLogin(LoginDto loginDto) {
        return userDao.getUserEntityByLogin(loginDto.getLogin()).getId();
    }

    public Long getIdUserByLogin(UserDto userDto) {
        return userDao.getUserEntityByLogin(userDto.getLogin()).getId();
    }

    public boolean isValid(LoginDto loginDto) {
        boolean result = true;
        User user = null;
        try {
            user = userDao.getUserEntityByLogin(loginDto.getLogin());
        } catch (Exception e) {
            // Logging Exception
            System.out.println("RuntimeException, message: " + e.getMessage());
            result = false;
        }
        result = result && (user.getPassword().equals(loginDto.getPassword()));
        return result;
    }

    public boolean isExist(RegistrationDto registrationDto) {
        User user = null;
        try {
        user = userDao.getUserEntityByLogin(registrationDto.getLogin());
        } catch (Exception e){
            System.out.println("RuntimeException, message: " + e.getMessage());
            return false;
        }
        return true;
	}

    public boolean checkPassword(RegistrationDto registrationDto) {
        if(registrationDto.getPassword().equals(registrationDto.getRetypePassword())){
            return true;
        } else {
            return false;
        }
    }

    public Visa [] getVisaByUserLogin(String login) {
        User user = null;
        List<Visa> visas = null;
        try {
            user = userDao.getUserEntityByLogin(login);
            visas = visaDao.getByFieldName("user_id", user.getId().toString());

        } catch (Exception e){
            System.out.println("RuntimeException, message: " + e.getMessage());
        }
        Visa visa [] = new Visa[visas.size()];
        for(int i = 0; i < visas.size(); i++){
            visa[i] = visas.get(i);
        }
        return visa;
    }

    public String getCountryById(Long id) {
        Country country = null;
        country = countryDao.getById(id);
        try {
            country = countryDao.getById(id);
        } catch (Exception e){
            System.out.println("RuntimeException, message: " + e.getMessage());
        }
        return country.getName();
    }



}
