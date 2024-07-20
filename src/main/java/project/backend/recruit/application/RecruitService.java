package project.backend.recruit.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.backend.recruit.application.request.RecruitCreateServiceRequest;
import project.backend.recruit.repository.RecruitRepository;
import project.backend.user.domain.User;
import project.backend.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RecruitService {

    private final RecruitRepository recruitRepository;
    private final UserRepository userRepository;

    @Transactional
    public void createRecruit(RecruitCreateServiceRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(RuntimeException::new);

        recruitRepository.save(request.toEntity(user));
    }

}
