package org.example.repository.impl;

import org.example.model.Role;
import org.example.repository.RoleRepository;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class RoleRepositoryImpl implements RoleRepository {
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public Role create(Role role) {
        try (Session session = sessionFactory.openSession()) {
            session.save(role);
        }
        return role;
    }

    @Override
    public Optional<Role> findById(Long id) {
        return Optional.ofNullable(sessionFactory.openSession().find(Role.class, id));
    }

    @Override
    public List<Role> findAll() {
        return sessionFactory.openSession()
            .createQuery("select r from Role r", Role.class)
            .getResultList();
    }
}
