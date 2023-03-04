package lk.ijse.dep9.repository;

import lk.ijse.dep9.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

    @Query(value = "SELECT * FROM item WHERE category=?1",nativeQuery = true)
    List<Item> getItemsByCategory(String category);
//    @Query(value = "SELECT category,COUNT(id) FROM item WHERE MIN(category)",nativeQuery = true)
//    int getCountOfItemsByCategory(String size);


}
