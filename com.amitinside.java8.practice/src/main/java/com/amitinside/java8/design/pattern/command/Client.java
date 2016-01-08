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
package com.amitinside.java8.design.pattern.command;

public final class Client {

	public static void main(final String[] args) {
		final Macro macro = new Macro();
		final Editor editor = new MockEditor();
		final Command openCommand = new Open(editor);
		final Command saveCommand = new Save(editor);

		macro.record(openCommand);
		macro.record(saveCommand);

		macro.run(); // 1st way

		macro.record(() -> new Open(editor));
		macro.record(() -> new Save(editor));

		macro.run(); // 2nd way

		macro.record(() -> editor.open());
		macro.record(() -> editor.save());

		macro.run(); // 3rd way

		macro.record(editor::open);
		macro.record(editor::save);

		macro.run(); // 4th way
	}

}
