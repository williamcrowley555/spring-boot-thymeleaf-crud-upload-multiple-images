package net.javaguides.springboot.service.impl;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;
import net.javaguides.springboot.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        Employee employee = null;
        if(optional.isPresent()) {
            employee = optional.get();
        }
        else {
            throw new RuntimeException("Employee Id:" + id + " does not exist");
        }
        return employee;
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection, String keyword) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
                : Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);;
        if(keyword != null) {
            return employeeRepository.findAll(keyword, pageable);
        }

        return employeeRepository.findAll(pageable);
    }

}
