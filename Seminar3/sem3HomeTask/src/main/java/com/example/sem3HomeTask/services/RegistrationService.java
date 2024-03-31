package com.example.sem3HomeTask.services;

import com.example.sem3HomeTask.domain.User;
import com.example.sem3HomeTask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {


    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    @Autowired
    private DataProcessingService dataProcessingService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private NotificationService notificationService;

    public void processRegistration(String name, int age, String email) {
        // Создание пользователя из параметров метода
        User user = userService.createUser(name, age, email);

        // Добавление созданного пользователя в репозиторий
        userRepository.getUsers().add(user);

        // Вывод сообщения в консоль через notificationService
        notificationService.notifyUser(user);
    }
}
