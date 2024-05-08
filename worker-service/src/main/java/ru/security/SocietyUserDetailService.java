package ru.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.model.Worker;
import ru.repository.WorkerRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SocietyUserDetailService implements UserDetailsService {

    private final WorkerRepository workerRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Worker worker = workerRepository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));

        return new User(worker.getLogin(), worker.getPassword(), List.of(new SimpleGrantedAuthority(worker.getNameSubdivision())
        ));
    }
}
