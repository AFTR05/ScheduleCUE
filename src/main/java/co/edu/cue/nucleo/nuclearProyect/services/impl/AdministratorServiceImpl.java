package co.edu.cue.nucleo.nuclearProyect.services.impl;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Administrator;
import co.edu.cue.nucleo.nuclearProyect.domain.entities.Student;
import co.edu.cue.nucleo.nuclearProyect.infrastructure.dao.ObjectDao;
import co.edu.cue.nucleo.nuclearProyect.mapping.dtos.AdminRequestDTO;
import co.edu.cue.nucleo.nuclearProyect.mapping.mappers.AdminMapper;
import co.edu.cue.nucleo.nuclearProyect.mapping.mappers.StudentMapper;
import co.edu.cue.nucleo.nuclearProyect.services.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class AdministratorServiceImpl implements AdminService {
    private final ObjectDao<Administrator> objectDao;
    private final AdminMapper mapper;
    @Override
    public List<AdminRequestDTO> getAllAdmins() {
        return objectDao.list()
                .parallelStream()
                .map(e -> mapper.mapToDTO((Administrator) e))
                .toList();
    }

    @Override
    public AdminRequestDTO createAdmin(AdminRequestDTO admin) {
        Administrator AdminnAb=mapper.mapToDTO(admin);
        AdminnAb.setId(admin.name());
        return mapper.mapToDTO(
                objectDao.save(AdminnAb
                ));
    }

    @Override
    public AdminRequestDTO updateAdmin(String id, AdminRequestDTO admin) {
        Administrator adminUp=mapper.mapToDTO(admin);
        adminUp.setId(id);
        return mapper.mapToDTO(objectDao.update(id,adminUp));
    }
}
