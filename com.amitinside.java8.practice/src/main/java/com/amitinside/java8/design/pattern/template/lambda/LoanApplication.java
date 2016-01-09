/*******************************************************************************
 * Copyright 2016 Amit Kumar Mondal
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.amitinside.java8.design.pattern.template.lambda;

import com.amitinside.java8.design.pattern.template.ApplicationDenied;

public class LoanApplication {

	private final Criteria creditHistory;
	private final Criteria identity;
	private final Criteria incomeHistory;

	public LoanApplication(final Criteria identity, final Criteria creditHistory, final Criteria incomeHistory) {

		this.identity = identity;
		this.creditHistory = creditHistory;
		this.incomeHistory = incomeHistory;
	}

	public void checkLoanApplication() throws ApplicationDenied {
		this.identity.check();
		this.creditHistory.check();
		this.incomeHistory.check();
		this.reportFindings();
	}

	private void reportFindings() {
	}

}
