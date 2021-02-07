package au.com.realestate.command;

import au.com.realestate.entity.Context;

public class Report implements Command {
  private final Context context;
  private final au.com.realestate.report.Report report;

  public Report(Context context, au.com.realestate.report.Report report) {
    this.context = context;
    this.report = report;
  }

  @Override
  public void execute() {
    report.report(context);
  }
}
