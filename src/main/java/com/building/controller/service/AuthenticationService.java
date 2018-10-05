package com.building.controller.service;

import com.building.controller.dto.ApplicationUserDto;
import com.building.controller.exception.ApplicationUserIsActiveException;
import com.building.controller.exception.ApplicationUserNotFoundException;
import com.building.controller.exception.EmailAlreadyRegisteredException;
import com.building.controller.exception.RegisterFailureException;
import com.building.controller.model.ApplicationUser;
import com.building.controller.repository.ApplicationUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
@RequiredArgsConstructor

public class AuthenticationService {
    private final ApplicationUserRepository applicationUserRepository;
    private final ConversionService conversionService;
    private final PasswordEncoder passwordEncoder;
    private final MailSender mailSender;

    @Value("${com.building.controller.activation.subject}")
    private String activationMailSubject;

    @Value("${com.building.controller.activation.message}")
    private String activationMailMessage;

    public void saveUser(ApplicationUser applicationUser) {
        if (applicationUserRepository.existsByEmail(applicationUser.getEmail())) {
            throw new EmailAlreadyRegisteredException();
        }
        String encodedPassword = passwordEncoder.encode(applicationUser.getPassword());
        applicationUser.setPassword(encodedPassword);
        applicationUser.setActivationHash(generateMd5HashCode(applicationUser.getEmail()));
        applicationUser.setActivated(false);
        mailSender.sendEmail(
                activationMailSubject,
                activationMailMessage + applicationUser.getActivationHash(),
                applicationUser.getEmail());
        this.applicationUserRepository.save(applicationUser);
    }

    public ApplicationUserDto getUserData(String email) {
        return applicationUserRepository
                .findByEmail(email)
                .map(user -> conversionService.convert(user, ApplicationUserDto.class))
                .orElseThrow(ApplicationUserNotFoundException::new);
    }

    public void activateUserDataByToken(String token) {
        ApplicationUser applicationUser =
                applicationUserRepository
                        .findByactivationHash(token)
                        .orElseThrow(ApplicationUserNotFoundException::new);
        if (applicationUser.isActivated()) {
            throw new ApplicationUserIsActiveException();
        }
        applicationUser.setActivated(true);
        applicationUser.setActivationHash(null);
        applicationUserRepository.save(applicationUser);
    }

    private String generateMd5HashCode(String md5) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            return DatatypeConverter.printHexBinary(array).toLowerCase();
        } catch (NoSuchAlgorithmException e) {
            throw new RegisterFailureException();
        }
    }
}
