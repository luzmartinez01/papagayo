package ln.mial.ecommerce.infraestructure.adapter;

import jakarta.transaction.Transactional;
import ln.mial.ecommerce.infraestructure.entity.PedidosEntity;
import ln.mial.ecommerce.infraestructure.entity.UsuariosEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import ln.mial.ecommerce.app.repository.PedidosRepository;
import ln.mial.ecommerce.infraestructure.entity.StatusPedido;

@Repository
public class PedidosRepositoryImpl implements PedidosRepository {
    private final PedidosCrudRepository orderCrudRepository;

    public PedidosRepositoryImpl(PedidosCrudRepository orderCrudRepository) {
        this.orderCrudRepository = orderCrudRepository;
    }

    @Override
    public List<PedidosEntity> getOrders() {
        return (List<PedidosEntity>) orderCrudRepository.findAll();
    }

    @Override
    public PedidosEntity getOrderById(Integer id) {
        return orderCrudRepository.findById(id).orElse(null);
    }

    @Override
    public List<PedidosEntity> getOrdersByUser(UsuariosEntity userEntity) {
        return orderCrudRepository.findByUser(userEntity);
    }

    @Override
    public PedidosEntity saveOrder(PedidosEntity ordersEntity) {
        return orderCrudRepository.save(ordersEntity);
    }

    @Override
    @Transactional
    public boolean deleteOrderById(Integer id) {
        orderCrudRepository.deleteById(id);
        return true;
    }
}
