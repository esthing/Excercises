package com.lst.exercise;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * rearrange student list according to their GPA in descending order. If two
 * students have the same GPA, then arrange them according to their first name
 * in alphabetical order. If those two students also have the same first name,
 * then sort them in ascending order according to their IDs. No two students
 * have the same ID.
 * 
 * @author SiekThing Lim
 * 
 */
public class StudentScoreSorter {

    public List<StudentScoreBO> getStudentList() {
        final List<StudentScoreBO> studentScoreList = new ArrayList<>();

        final StudentScoreBO student1 = new StudentScoreBO();
        student1.setId("33");
        student1.setFirstName("Tina");
        student1.setGpa(new BigDecimal(3.68));
        final StudentScoreBO student2 = new StudentScoreBO();
        student2.setId("85");
        student2.setFirstName("Louis");
        student2.setGpa(new BigDecimal(3.85));
        final StudentScoreBO student3 = new StudentScoreBO();
        student3.setId("56");
        student3.setFirstName("Samil");
        student3.setGpa(new BigDecimal(3.75));
        final StudentScoreBO student4 = new StudentScoreBO();
        student4.setId("19");
        student4.setFirstName("Samar");
        student4.setGpa(new BigDecimal(3.75));
        final StudentScoreBO student5 = new StudentScoreBO();
        student5.setId("22");
        student5.setFirstName("Lorry");
        student5.setGpa(new BigDecimal(3.76));

        studentScoreList.add(student1);
        studentScoreList.add(student2);
        studentScoreList.add(student3);
        studentScoreList.add(student4);
        studentScoreList.add(student5);

        return studentScoreList;
    }

    public void sortByGpaThenName(final List<StudentScoreBO> bestScorers) {
        if ( !bestScorers.isEmpty() ) {
            Collections.sort(bestScorers, new Comparator<StudentScoreBO>() {
                @Override
                public int compare(final StudentScoreBO o1,
                        final StudentScoreBO o2) {
                    final BigDecimal compareGpa1 = o1.getGpa();
                    final BigDecimal compareGpa2 = o2.getGpa();
                    final int iResultGpa = compareGpa2.compareTo(compareGpa1);
                    if ( iResultGpa == 0 ) {
                        final String compareName1 = o1.getFirstName();
                        final String compareName2 = o2.getFirstName();
                        final int iResultFirstName = compareName1
                                .compareTo(compareName2);
                        if ( iResultFirstName == 0 ) {
                            final String compareId1 = o1.getId();
                            final String compareId2 = o2.getId();
                            return compareId1.compareTo(compareId2);
                        }
                        return iResultFirstName;
                    }
                    return iResultGpa;
                }
            });
        }
    }

    public static void main(String[] args) {
        final StudentScoreSorter sorter = new StudentScoreSorter();
        final List<StudentScoreBO> studentList = sorter.getStudentList();
        sorter.sortByGpaThenName(studentList);
        for (final StudentScoreBO studentBO : studentList) {
            System.out.println(studentBO.getFirstName());
        }
    }

}
