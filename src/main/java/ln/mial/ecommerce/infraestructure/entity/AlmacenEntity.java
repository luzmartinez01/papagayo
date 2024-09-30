package ln.mial.ecommerce.infraestructure.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "almacen")
public class AlmacenEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private Integer stockQuantity; // Cantidad de stock actual
    private LocalDateTime entryDate; // Fecha de entrada del stock
    private LocalDateTime lastRestockedDate; // Última fecha de reabastecimiento
    
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private ProductosEntity product;

    public AlmacenEntity() {
    }

    public AlmacenEntity(Integer id, Integer stockQuantity, LocalDateTime entryDate, LocalDateTime lastRestockedDate, ProductosEntity product) {
        this.id = id;
        this.stockQuantity = stockQuantity;
        this.entryDate = entryDate;
        this.lastRestockedDate = lastRestockedDate;
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public LocalDateTime getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDateTime entryDate) {
        this.entryDate = entryDate;
    }

    public ProductosEntity getProduct() {
        return product;
    }

    public void setProduct(ProductosEntity product) {
        this.product = product;
    }

    public LocalDateTime getLastRestockedDate() {
        return lastRestockedDate;
    }

    public void setLastRestockedDate(LocalDateTime lastRestockedDate) {
        this.lastRestockedDate = lastRestockedDate;
    }
    
    
}
