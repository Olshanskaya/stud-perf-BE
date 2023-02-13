package student.perfomance.services;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import student.perfomance.dtos.AcademicPlanDto;
import student.perfomance.entitys.AcademicPlan;
import student.perfomance.enums.ElementStatus;
import student.perfomance.repository.AcademicPlanRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AcademicPlanService {
    private final AcademicPlanRepository academicPlanRepository;
    private final ModelMapper modelMapper;

    public List<AcademicPlanDto> getAllAcademicPlan() {
        List<AcademicPlanDto> dtos = academicPlanRepository.findAll()
                .stream()
                .map(c -> modelMapper.map(c, AcademicPlanDto.class))
                .toList();
        return dtos;
    }

    public AcademicPlanDto getAcademicPlanId(Long id) {
        return modelMapper.map(academicPlanRepository.findById(id), AcademicPlanDto.class);
    }

    public boolean createAcademicPlan(AcademicPlanDto academicPlanDto) {
        if (academicPlanDto.getId() == null || academicPlanRepository.findById(academicPlanDto.getId()).isEmpty()) {
            AcademicPlan ap = academicPlanRepository.save(modelMapper.map(academicPlanDto, AcademicPlan.class));
            return true;
        }
        return false;
    }

    public boolean updateAcademicPlan(AcademicPlanDto academicPlanDto) {
        Optional<AcademicPlan> ap = academicPlanRepository.findById(academicPlanDto.getId());
        if (ap.isPresent()) {
            AcademicPlan c = ap.get();
            c = modelMapper.map(academicPlanDto, AcademicPlan.class);
            academicPlanRepository.save(c);
            return true;
        }
        return false;
    }

    public boolean deleteAcademicPlan(Long id) {
        Optional<AcademicPlan> ap = academicPlanRepository.findById(id);
        if (ap.isPresent()) {
            AcademicPlan c = ap.get();
            c.setStatus(ElementStatus.DELETED.toString());
            academicPlanRepository.save(c);
            return true;
        }
        return false;
    }

}
