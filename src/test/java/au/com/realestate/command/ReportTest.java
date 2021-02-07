package au.com.realestate.command;

import au.com.realestate.entity.Context;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ReportTest {
  @Test
  void shouldCreateReportOnExecute() {
    Context context = mock(Context.class);
    au.com.realestate.report.Report consoleReport = mock(au.com.realestate.report.Report.class);
    Report report = new Report(context, consoleReport);

    report.execute();

    verify(consoleReport).report(context);
  }

}
