package ru.vlsu.ispi.springproject.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vlsu.ispi.springproject.dto.NotificationSettingsRequestDto;
import ru.vlsu.ispi.springproject.services.NotificationService;

@RestController
@RequestMapping("/settings/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService){
        this.notificationService = notificationService;
    }

    @PutMapping("/accept")
    public String updateNotifications(@RequestBody NotificationSettingsRequestDto request) {
        return notificationService.updateNotifications(request);
    }

    @DeleteMapping("/reset")
    public String resetNotifications() {
        return notificationService.resetNotifications();
    }
}
