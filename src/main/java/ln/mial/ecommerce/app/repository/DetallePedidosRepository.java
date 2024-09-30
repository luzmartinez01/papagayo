package ln.mial.ecommerce.app.repository;

import ln.mial.ecommerce.infraestructure.entity.DetallePedidosEntity;
import ln.mial.ecommerce.infraestructure.entity.PedidosEntity;

import java.util.List;

public interface DetallePedidosRepository {
    List<DetallePedidosEntity> getOrderDetails();
    DetallePedidosEntity getOrderDetailById(Integer id);
    List<DetallePedidosEntity> getOrderDetailsByOrder(PedidosEntity orderEntity);
    DetallePedidosEntity saveOrderDetail(DetallePedidosEntity orderDetailsEntity);
    boolean deleteOrderDetailById(Integer id);
}

