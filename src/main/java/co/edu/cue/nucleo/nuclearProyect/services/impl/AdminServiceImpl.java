package co.edu.cue.nucleo.nuclearProyect.services.impl;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Administrator;
import co.edu.cue.nucleo.nuclearProyect.domain.enums.TypeAdmin;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.ObjectDao;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.AdminInterfaceDTO;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.AdminRequestDTO;
import co.edu.cue.nucleo.nuclearProyect.mapping.mappers.AdminMapper;
import co.edu.cue.nucleo.nuclearProyect.services.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class AdminServiceImpl implements AdminService {
    private final ObjectDao<Administrator> objectDao;
    private final AdminMapper mapper;
    private final ObjectDao<TypeAdmin> typeDao;

        /**
         * Obtiene una lista de todos los administradores.
         *
         * @return Lista de objetos AdminRequestDTO que representan a los administradores.
         */
    @Override
    public List<AdminRequestDTO> getAllAdmins() {
        return objectDao.list()
                .parallelStream()
                .map(mapper::mapToDTO)
                .toList();
    }

    /**
     * Obtiene un administrador basado en el ID proporcionado.
     *
     * @param id ID del administrador a buscar.
     * @return Objeto AdminRequestDTO que representa al administrador encontrado.
     */
    @Override
    public AdminRequestDTO getOneAdmin(String id){
        return mapper.mapToDTO(
                objectDao.byId(id));
    }

        /**
         * Crea un nuevo administrador.
         *
         * @param admin Objeto AdminRequestDTO que contiene los detalles del administrador a crear.
         * @return Objeto AdminRequestDTO que representa al administrador creado.
         */
    @Override
    public AdminRequestDTO createAdmin(AdminInterfaceDTO admin) {
        Administrator AdminnAb=mapper.mapToEntity(new AdminRequestDTO(admin.id(), admin.name(),
                admin.email(),typeDao.byName(admin.typeAdmin()),admin.active()));
        AdminnAb.setPassword(AdminnAb.getId());
        return mapper.mapToDTO(
                objectDao.save(AdminnAb
                ));
    }

        /**
         * Actualiza un administrador existente.
         *
         * @param admin    Objeto AdminRequestDTO que contiene los detalles actualizados del administrador.
         * @param password Contraseña requerida para realizar la actualización.
         * @return Objeto AdminRequestDTO que representa al administrador actualizado.
         */

    @Override
    public AdminRequestDTO updateAdmin(AdminRequestDTO admin, String password) {
        Administrator a=mapper.mapToEntity(admin);
        a.setPassword(password);
        return mapper.mapToDTO(objectDao.update(admin.id(),a));
    }
}
