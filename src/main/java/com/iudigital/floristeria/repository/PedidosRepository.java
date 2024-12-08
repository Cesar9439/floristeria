package com.iudigital.floristeria.repository;

import com.iudigital.floristeria.models.Flor;
import com.iudigital.floristeria.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PedidosRepository extends JpaRepository<Pedido, Long> {
    Optional<Pedido> findById(Long id);

    @Query("SELECT p.tipoArreglo AS tipoArreglo, COUNT(p) AS popularidad " +
            "FROM Pedido p " +
            "GROUP BY p.tipoArreglo " +
            "ORDER BY popularidad DESC")
    List<Object[]> findArrangementPopularity();

    @Query("SELECT c.nombre AS nombre, SUM(p.presupuesto) AS ingresosTotales " +
            "FROM Pedido p " +
            "JOIN Cliente c ON p.cliente.id = c.id " +
            "GROUP BY c.nombre " +
            "ORDER BY ingresosTotales DESC")
    List<Object[]> findIncomeByClient();
}
