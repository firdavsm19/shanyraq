package com.Firdavs.shanyraq.announcement_service.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Firdavs.shanyraq.announcement_service.dto.AnnouncementCreateRequest;
import com.Firdavs.shanyraq.announcement_service.dto.AnnouncementDto;
import com.Firdavs.shanyraq.announcement_service.service.AnnouncementService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/announcements")
public class AnnouncementController {
    private final AnnouncementService announcementService;
    //post /api/announcements
    @PostMapping
    public ResponseEntity<AnnouncementDto> createAnnouncement(@RequestBody AnnouncementCreateRequest announcementDto){
        return ResponseEntity.ok(announcementService.createAnnouncement(announcementDto));
    }

    //get /api/announcements/{id}
 
    //put /api/announcements/{id}

    //delete /api/announcements/{id}

    //patch /api/announcements/{id}/archive

    //patch /api/announcements/{id}/publish

    //get /api/announcements

    //get /api/announcements/search

    //get /api/announcements/my

    //get /api/announcements/drafts
    
}
