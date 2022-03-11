package uz.pdp.task1.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.task1.entity.RoomEntity;

public interface RoomRepository extends JpaRepository<RoomEntity, Integer> {

    @Query("select r from RoomEntity r where r.hotel.id = ?1")
    Page<RoomEntity> findAllByHotelId(Integer id, Pageable pageable);
}
