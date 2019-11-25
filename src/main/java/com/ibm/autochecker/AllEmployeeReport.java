package com.ibm.autochecker;

import java.util.List;

class AllEmployeeReport {

    private final String html;

    static AllEmployeeReport create(
            final List<Employee> employees) {
        final StringBuilder htmlBuilder = new StringBuilder(
                "<h2>All companies report</h2><br/>"
        );
        htmlBuilder.append("<ul>");
        for (final Employee employee : employees) {
            htmlBuilder
                    .append("<li>")
                    .append("<h3>").append(employee.getName()).append("</h3>")
                    .append("<b>Id:</b> ").append(employee.getId())
                    .append("<br/><b>Age:</b> ").append(employee.getAge())
                    .append("<br/><b>Address:</b> ").append(employee.getAddress())
                    .append("<br/><b>Salary:</b> ").append(employee.getSalary())
                    .append("</li>");
        }
        htmlBuilder.append("</ul>");

        return new AllEmployeeReport(htmlBuilder.toString());
    }
    private AllEmployeeReport(final String html) {
        this.html = html;
    }

    String getHtml() {
        return html;
    }
}
