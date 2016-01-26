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
package com.amitinside.java8.design.pattern.decorator;

import java.util.function.Function;
import java.util.stream.Stream;

public final class Application {

	@SafeVarargs
	private static Function<Candidate, Candidate> decorateEvaluators(
			final Function<Candidate, Candidate>... evaluators) {
		// return Stream.of(evaluators).reduce((func1, func2) ->
		// func1.andThen(func2)).orElse(candidate -> candidate);
		// return
		// Stream.of(evaluators).reduce(Function::andThen).orElse(Function.identity());
		return Stream.of(evaluators).reduce(Function.identity(), Function::andThen);
	}

	private static void evaluateCandidate(final Candidate candidate, final Function<Candidate, Candidate> evaluator) {
		System.out.println(evaluator.apply(candidate));

	}

	public static void main(final String[] args) {
		final Candidate candidate = new Candidate("AMIT");
		evaluateCandidate(candidate, decorateEvaluators(ResidenceEvaluator::evaluate, CrimeEvaluator::evaluate,
				ExperienceEvaluator::evaluate));
		;
	}

}
