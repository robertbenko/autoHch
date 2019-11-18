package com.ibm.autochecker;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Supplier;

public  class AllEmployeeReport {

    private static final String REPORT_MAIL_TITLE = "All companies report";

    private final String html;

    static AllEmployeeReport create(
            final List<Employee> employees,
            final Supplier<LocalDateTime> currentTimeSupplier) {
        final StringBuilder htmlBuilder = new StringBuilder(
                "<h2>All companies report</h2><br/>" +
                        "<b>Created at:</b> " + currentTimeSupplier.get() + "<br/><br/>"
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

    public AllEmployeeReport(final String html) {
        this.html = html;
    }

    void send(
            final EmailService emailService) {
        emailService.sendEmail(REPORT_MAIL_TITLE, html);
    }
}
