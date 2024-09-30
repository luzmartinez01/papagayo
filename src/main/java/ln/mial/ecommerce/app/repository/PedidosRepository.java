package ln.mial.ecommerce.app.repository;

import ln.mial.ecommerce.infraestructure.entity.PedidosEntity;
import ln.mial.ecommerce.infraestructure.entity.UsuariosEntity;

import java.util.List;

public interface PedidosRepository {
    List<PedidosEntity> getOrders();
    PedidosEntity getOrderById(Integer id);
    List<PedidosEntity> getOrdersByUser(UsuariosEntity userEntity);
    PedidosEntity saveOrder(PedidosEntity ordersEntity);
    boolean deleteOrderById(Integer id);
}

