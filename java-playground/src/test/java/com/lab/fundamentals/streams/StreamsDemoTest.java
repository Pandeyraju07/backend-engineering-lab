package com.lab.fundamentals.streams;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StreamsDemoTest {

    @Test
    void filterMapYieldsActiveNames() {
        List<Employee> roster = FilterMapDemo.sampleRoster();

        assertEquals(List.of("Asha", "Ravi", "Kiran", "Neha"), FilterMapDemo.activeNames(roster));
        assertEquals(List.of("Asha", "Kiran"), FilterMapDemo.namesInDepartment(roster, "Engineering"));
        assertEquals(List.of("ASHA", "RAVI", "KIRAN", "NEHA"), FilterMapDemo.uppercaseActiveNames(roster));
        assertEquals(4, FilterMapDemo.activeEmployees(roster).size());
    }

    @Test
    void collectorsGroupByDeptAndJoinNames() {
        List<Employee> roster = FilterMapDemo.sampleRoster();

        Map<String, List<Employee>> byDept = CollectorsDemo.groupByDepartment(roster);
        assertEquals(3, byDept.size());
        assertEquals(2, byDept.get("Engineering").size());
        assertEquals(2, byDept.get("Finance").size());

        assertEquals("Asha, Ravi, Kiran, Neha", CollectorsDemo.joinActiveNames(roster));
        assertEquals("Asha | Kiran", CollectorsDemo.joinDepartmentNames(roster, "Engineering"));
        assertEquals(2L, CollectorsDemo.countByDepartment(roster).get("Engineering"));
    }

    @Test
    void reduceTotalsPayrollSalaries() {
        List<Employee> roster = FilterMapDemo.sampleRoster();

        assertEquals(412_000.0, ReduceDemo.totalSalary(roster));
        assertEquals(324_000.0, ReduceDemo.totalActiveSalary(roster));
        assertEquals(95_000.0, ReduceDemo.maxSalary(roster).orElseThrow());
        assertEquals(4, ReduceDemo.activeCount(roster));
    }

    @Test
    void payrollPipelineIntegratesFilterMapCollectorsReduce() {
        StreamsDemo.StreamPayrollResult result =
                StreamsDemo.runPayrollPipeline(FilterMapDemo.sampleRoster());

        assertEquals(List.of("Asha", "Ravi", "Kiran", "Neha"), result.activeNames());
        assertEquals(List.of("Asha", "Kiran"), result.engineeringNames());
        assertEquals(3, result.departmentCount());
        assertEquals(2, result.activeEngineeringCount());
        assertEquals("Asha, Ravi, Kiran, Neha", result.joinedActiveNames());
        assertEquals(412_000.0, result.totalPayroll());
        assertEquals(324_000.0, result.activePayroll());
        assertEquals(95_000.0, result.topSalary());
        assertEquals(4, result.activeHeadcount());
    }
}
