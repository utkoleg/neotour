package com.example.neotour.controllers;

import com.example.neotour.dto.request.ReservationRequestDTO;
import com.example.neotour.dto.response.TourResponseDTO;
import com.example.neotour.services.CommentService;
import com.example.neotour.services.ReservationService;
import com.example.neotour.services.TourService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/neotour/tours")
@CrossOrigin("*")
public class TourController {
    private final TourService tourService;
    private final CommentService commentService;
    private final ReservationService reservationService;

    @GetMapping()
    public List<TourResponseDTO> getTours() {
        return tourService.getTours();
    }

    @PostMapping()
    public UUID addTour(@RequestParam(name = "tourName") String tourName,
                        @RequestParam(name = "tourDescription") String tourDescription,
                        @RequestParam(name = "tourLocation") String tourLocation,
                        @RequestParam(name = "tourImage") MultipartFile image) throws Exception {
        return tourService.addTour(tourName, tourDescription, tourLocation, image);
    }

    @GetMapping("/{id}")
    public TourResponseDTO getTourById(@PathVariable(name = "id") UUID id) {
        return tourService.getTourById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTourById(@PathVariable(name = "id") UUID id){
        tourService.deleteTourById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/addComment")
    public UUID addComment(@PathVariable(name = "id") UUID id,
                              @RequestParam(name = "commentUsername") String commentUsername,
                              @RequestParam(name = "commentText") String commentText,
                              @RequestParam(name = "commentImage") MultipartFile image){
        return commentService.addComment(id, commentUsername, commentText, image);
    }

    @PostMapping("/{id}/addReservation")
    public UUID addReservation(@PathVariable(name = "id") UUID id,
                                      @RequestBody ReservationRequestDTO reservationRequestDTO){
        return reservationService.addReservation(reservationRequestDTO, id);
    }
}
