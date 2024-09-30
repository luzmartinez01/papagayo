package ln.mial.ecommerce.infraestructure.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "pago")
public class PagosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String paymentMethod; // método de pago
    private BigDecimal amount; // monto
    private LocalDateTime paymentDate; // fecha de pago
    private String paymentStatus; // Exitoso, Fallido, etc.

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private PedidosEntity order;

    public PagosEntity() {
    }

    public PagosEntity(Integer id, String paymentMethod, BigDecimal amount, LocalDateTime paymentDate, String paymentStatus, PedidosEntity order) {
        this.id = id;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentStatus = paymentStatus;
        this.order = order;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public PedidosEntity getOrder() {
        return order;
    }

    public void setOrder(PedidosEntity order) {
        this.order = order;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    
}

