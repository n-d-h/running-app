package com.nib.runningapp.services.impl;

import com.nib.runningapp.dtos.UserDTO;
import com.nib.runningapp.dtos.UserSubscriptionCreateDTO;
import com.nib.runningapp.dtos.UserSubscriptionDTO;
import com.nib.runningapp.entities.User;
import com.nib.runningapp.entities.UserSubscription;
import com.nib.runningapp.mappers.UserSubscriptionMapper;
import com.nib.runningapp.repositories.UserSubscriptionRepository;
import com.nib.runningapp.services.UserSubscriptionService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Transactional
@Service
@RequiredArgsConstructor
public class UserSubscriptionServiceImpl implements UserSubscriptionService {
    private final UserSubscriptionRepository userSubscriptionRepository;

    @Override
    public UserSubscriptionDTO createSubscription(UserSubscriptionCreateDTO dto) {
        UserSubscriptionDTO userSubscriptionDTO = toDTO(dto);
        UserSubscription userSubscription = UserSubscriptionMapper.INSTANCE.toEntity(userSubscriptionDTO);
        userSubscription.setStatus(true);
        return UserSubscriptionMapper.INSTANCE.toDTO(userSubscriptionRepository.save(userSubscription));
    }

    @Override
    public UserSubscriptionDTO updateSubscription(UserSubscriptionCreateDTO dto) {
        UserSubscriptionDTO userSubscriptionDTO = toDTO(dto);
        UserSubscription userSubscription = UserSubscriptionMapper.INSTANCE.toEntity(userSubscriptionDTO);
        userSubscription.setStatus(true);
        return UserSubscriptionMapper.INSTANCE.toDTO(userSubscriptionRepository.save(userSubscription));
    }


    protected UserSubscriptionDTO toDTO(UserSubscriptionCreateDTO dto) {
        UserSubscriptionDTO userSubscriptionDTO = new UserSubscriptionDTO();
        userSubscriptionDTO.setSubscriptionId(null);
        userSubscriptionDTO.setStartDate(dto.getStartDate());
        userSubscriptionDTO.setEndDate(dto.getEndDate());
        userSubscriptionDTO.setUserId(dto.getUserId());
        userSubscriptionDTO.setUsername(null);
        userSubscriptionDTO.setSubscriptionId(dto.getSubscriptionId());
        userSubscriptionDTO.setSubscriptionType(null);
        return userSubscriptionDTO;
    }

}
