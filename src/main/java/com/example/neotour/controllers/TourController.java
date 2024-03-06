package com.example.neotour.controllers;

import com.example.neotour.dto.request.ReservationRequestDTO;
import com.example.neotour.dto.request.TourRequestDTO;
import com.example.neotour.dto.response.TourResponseDTO;
import com.example.neotour.services.CommentService;
import com.example.neotour.services.ReservationService;
import com.example.neotour.services.TourService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Tour controller")
public class TourController {
    private final TourService tourService;
    private final CommentService commentService;
    private final ReservationService reservationService;

    @Operation(summary = "Get all tours",
            description = "Retrieve a list of all tours.")
    @GetMapping()
    public List<TourResponseDTO> getTours() {
        return tourService.getTours();
    }

    @Operation(summary = "Add a new tour",
            description = "Add a new tour to the system.")
    @ApiResponse(responseCode = "200",
            description = "Tour ID of the newly added tour.",
            content = @Content(
                    schema = @Schema(
                            implementation = UUID.class)))
    @PostMapping()
    public UUID addTour(@RequestParam(name = "tourName") String tourName,
                        @RequestParam(name = "tourDescription") String tourDescription,
                        @RequestParam(name = "tourLocation") String tourLocation,
                        @RequestParam(name = "tourImage") MultipartFile image) throws Exception {
        return tourService.addTour(tourName, tourDescription, tourLocation, image);
    }

    @Operation(summary = "Get tour by ID",
            description = "Retrieve a specific tour by its ID.")
    @ApiResponse(responseCode = "200",
            description = "The requested tour.",
            content = @Content(
                    schema = @Schema(
                            implementation = TourResponseDTO.class)))
    @GetMapping("/{id}")
    public TourResponseDTO getTourById(@PathVariable(name = "id") UUID id) {
        return tourService.getTourById(id);
    }

    @Operation(summary = "Delete tour by ID",
            description = "Delete a specific tour by its ID.")
    @ApiResponse(responseCode = "200",
            description = "Tour deleted successfully.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTourById(@PathVariable(name = "id") UUID id){
        tourService.deleteTourById(id);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Add comment to tour",
            description = "Add a comment to a specific tour.")
    @ApiResponse(responseCode = "200",
            description = "Comment ID of the added comment.",
            content = @Content(
                    schema = @Schema(
                            implementation = UUID.class)))
    @PostMapping("/{id}/addComment")
    public UUID addComment(@PathVariable(name = "id") UUID id,
                              @RequestParam(name = "commentUsername") String commentUsername,
                              @RequestParam(name = "commentText") String commentText,
                              @RequestParam(name = "commentImage") MultipartFile image){
        return commentService.addComment(id, commentUsername, commentText, image);
    }

    @Operation(summary = "Add reservation to tour",
            description = "Add a reservation to a specific tour.")
    @ApiResponse(responseCode = "200",
            description = "Reservation ID of the added reservation.",
            content = @Content(
                    schema = @Schema(
                            implementation = UUID.class)))
    @PostMapping("/{id}/addReservation")
    public UUID addReservation(@PathVariable(name = "id") UUID id,
                                      @RequestBody ReservationRequestDTO reservationRequestDTO){
        return reservationService.addReservation(reservationRequestDTO, id);
    }
}
