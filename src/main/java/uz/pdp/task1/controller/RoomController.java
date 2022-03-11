package uz.pdp.task1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import uz.pdp.task1.entity.RoomEntity;
import uz.pdp.task1.repository.RoomRepository;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/room")
public class RoomController {

    private final RoomRepository roomRepository;

    @GetMapping("/{hotelId}")
    public Page<RoomEntity> getAllRoomByHotelId(@PathVariable("hotelId") Integer id, @RequestParam("page") int page){
        Pageable pageable = PageRequest.of(page, 10);
        return roomRepository.findAllByHotelId(id, pageable);
    }
}
