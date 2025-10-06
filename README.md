# Kiuwan & TestRail Integration Demo

This repository demonstrates a **low-code approach** to integrating **Kiuwan SAST (Static Application Security Testing)** results into **TestRail** using the **TestRail CLI** and **JUnit XML reports**.

> ⚠️ **Important:** This project is **intentionally insecure** and contains known vulnerabilities for the purpose of static analysis and security scanning demos. It is designed specifically to generate findings when scanned by Kiuwan and to showcase integration workflows with TestRail. **Do not use in production.**

---

## Overview

- **Kiuwan** performs static code analysis and outputs results including audit checkpoints.  
- These results are converted into **JUnit XML** format for compatibility with TestRail.  
- Using the **TestRail CLI**, test cases are automatically created and updated in TestRail with PASS/FAIL status.

---

## How it Works

1. **Code is analyzed** by Kiuwan (this repo intentionally includes multiple security vulnerabilities for scanning).  
2. **Audit results** are exported and mapped to test outcomes.  
3. **JUnit XML** file is generated based on the audit score and findings.  
4. **TestRail CLI** sends the results to TestRail, updating test cases accordingly.

---

## Prerequisites

- A working **Kiuwan** account and CLI tool.  
- **TestRail** instance with CLI access configured.  
- JUnit XML report generator (script/tooling to convert Kiuwan output).

---

## Usage (example)

1. Analyze code with Kiuwan (example CLI usage, adapt to your environment):
    ```bash
    kiuwan analyze -a myApp -s . --format json -o kiuwan-output.json
    ```

2. Export audit checkpoints as JUnit XML (example—replace with your converter or Kiuwan API call):
    ```bash
    # hypothetical script that converts Kiuwan JSON -> junit.xml
    python3 tools/kiuwan-to-junit.py kiuwan-output.json results/junit.xml
    ```

3. Push JUnit XML to TestRail using the TestRail CLI:
    ```bash
    testrail-cli results:add --project MyProject --suite Default --file results/junit.xml
    ```

*(Exact CLI flags and commands vary by tooling and environment — this is a conceptual example.)*

---

## Sample Output

Test results in TestRail may look like:
- ✅ Passed (based on passing audit thresholds)  
- ❌ Failed (if audit thresholds not met or critical issues found)

---

## Benefits

- Simplifies SAST result tracking in TestRail.  
- Enables automated test result updates.  
- Integrates security audits into QA workflows.  
- Provides a reproducible environment to demonstrate Kiuwan + TestRail integration using intentionally vulnerable Java code.

---

## Safety & Notes

- This repository intentionally contains insecure code patterns (hard-coded credentials, SQL concatenation, weak cryptography, XXE, unsafe deserialization, command execution, and a deliberately outdated `jackson-databind` dependency).  
- **Do not** deploy this code or run it on production or sensitive systems. Use an isolated environment (VM/container) for scanning and demos.  
- If you want, I can add:
  - a sample `.kiuwan` configuration or Kiuwan export script,  
  - a converter script that produces JUnit XML from Kiuwan output, or  
  - a GitHub Actions workflow that runs Kiuwan and then exports results for TestRail.
