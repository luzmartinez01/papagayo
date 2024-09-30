package ln.mial.ecommerce.infraestructure.adapter;

import ln.mial.ecommerce.infraestructure.entity.AlmacenEntity;
import org.springframework.data.repository.CrudRepository;

public interface AlmacenCrudRepository extends CrudRepository<AlmacenEntity, Integer> {
}
