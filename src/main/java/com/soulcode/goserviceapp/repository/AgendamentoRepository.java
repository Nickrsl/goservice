package com.soulcode.goserviceapp.repository;

import com.soulcode.goserviceapp.domain.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.time.LocalDate;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    @Query(value="SELECT a.* FROM agendamentos a JOIN usuarios u ON a.cliente_id = u.id WHERE u.email = ? ORDER BY data", nativeQuery = true)
    List<Agendamento> findByClienteEmail(String email);

    @Query(value = "SELECT a.* FROM agendamentos a JOIN usuarios u ON a.prestador_id = u.id WHERE u.email = ? ORDER BY data", nativeQuery = true)
    List<Agendamento> findByPrestadorEmail(String email);


    @Query(value = "SELECT status_agendamento\n" +
            "FROM agendamentos", nativeQuery = true)
    List<String> totalAgendamentosByStatus();

    @Query(value = "SELECT a.* FROM agendamentos a WHERE a.data = ? AND a.prestador_id = ?", nativeQuery = true)
    List<Agendamento> findByDataPrestador(LocalDate data, Long idPrestador);

   
}
