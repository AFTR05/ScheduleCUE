package co.edu.cue.nucleo.nuclearProyect.services.impl;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Administrator;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.ObjectDao;
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
    @Override
    public List<AdminRequestDTO> getAllAdmins() {
        return objectDao.list()
                .parallelStream()
                .map(mapper::mapToDTO)
                .toList();
    }

    @Override
    public AdminRequestDTO getOneAdmin(String id){
        return mapper.mapToDTO(
                objectDao.byId(id));
    }

    @Override
    public AdminRequestDTO createAdmin(AdminRequestDTO admin) {
        Administrator AdminnAb=mapper.mapToDTO(admin);
        AdminnAb.setPassword(AdminnAb.getId());
        return mapper.mapToDTO(
                objectDao.save(AdminnAb
                ));
    }

    @Override
    public AdminRequestDTO updateAdmin(AdminRequestDTO admin, String password) {
        Administrator a=mapper.mapToDTO(admin);
        a.setPassword(password);
        return mapper.mapToDTO(objectDao.update(admin.id(),a));
    }
}
