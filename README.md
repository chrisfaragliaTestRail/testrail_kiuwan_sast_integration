# Kiuwan & TestRail Integration Demo

This repository demonstrates a **low-code approach** to integrating **Kiuwan SAST (Static Application Security Testing)** results into **TestRail** using the **TestRail CLI** and **JUnit XML reports**.

## Overview

- **Kiuwan** performs static code analysis and outputs results including audit checkpoints.
- These results are converted into **JUnit XML** format for compatibility with TestRail.
- Using the **TestRail CLI**, test cases are automatically created and updated in TestRail with PASS/FAIL status.

## How it Works

1. **Code is analyzed** by Kiuwan.
2. **Audit results** are exported and mapped to test outcomes.
3. **JUnit XML** file is generated based on the audit score and findings.
4. **TestRail CLI** sends the results to TestRail, updating test cases accordingly.

## Prerequisites

- A working **Kiuwan** account and CLI tool
- **TestRail** instance with CLI access configured
- JUnit XML report generator (script/tooling to convert Kiuwan output)

## Sample Output

Test results in TestRail may look like:
- ✅ Passed (based on passing audit thresholds)
- ❌ Failed (if audit thresholds not met or critical issues found)

## Benefits

- Simplifies SAST result tracking in TestRail
- Enables automated test result updates
- Integrates security audits into QA workflows
