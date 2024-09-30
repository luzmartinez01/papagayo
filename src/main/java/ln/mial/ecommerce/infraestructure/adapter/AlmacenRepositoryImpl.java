package ln.mial.ecommerce.infraestructure.adapter;

import jakarta.transaction.Transactional;
import ln.mial.ecommerce.infraestructure.entity.AlmacenEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import ln.mial.ecommerce.app.repository.AlmacenRepository;

@Repository
public class AlmacenRepositoryImpl implements AlmacenRepository {
    private final AlmacenCrudRepository warehouseCrudRepository;

    public AlmacenRepositoryImpl(AlmacenCrudRepository warehouseCrudRepository) {
        this.warehouseCrudRepository = warehouseCrudRepository;
    }

    @Override
    public List<AlmacenEntity> getWarehouses() {
        return (List<AlmacenEntity>) warehouseCrudRepository.findAll();
    }

    @Override
    public AlmacenEntity getWarehouseById(Integer id) {
        return warehouseCrudRepository.findById(id).orElse(null);
    }

    @Override
    public AlmacenEntity saveWarehouse(AlmacenEntity warehouseEntity) {
        return warehouseCrudRepository.save(warehouseEntity);
    }

    @Override
    @Transactional
    public boolean deleteWarehouseById(Integer id) {
        warehouseCrudRepository.deleteById(id);
        return true;
    }
}
