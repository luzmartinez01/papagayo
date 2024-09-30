package ln.mial.ecommerce.app.repository;

import ln.mial.ecommerce.infraestructure.entity.AlmacenEntity;

import java.util.List;

public interface AlmacenRepository {
    List<AlmacenEntity> getWarehouses();
    AlmacenEntity getWarehouseById(Integer id);
    AlmacenEntity saveWarehouse(AlmacenEntity warehouseEntity);
    boolean deleteWarehouseById(Integer id);
}
