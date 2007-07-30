/*
 * Created on 29 Jul 2007
 *
 * Copyright 2007 John G. Wilson
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */
import groovy.lang.GroovyShell;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.codehaus.groovy.control.CompilationFailedException;

import uk.co.wilson.groovy.graphbuilder.Graph;


public class TestGraphBuilder {

  /**
   * @param args
   * @throws IOException
   * @throws CompilationFailedException
   */
  public static void main(final String[] args) throws CompilationFailedException, IOException {
  final File dir = new File("src");
    ((Graph)new GroovyShell().evaluate(new File(dir, "example.groovy"))).writeTo(new FileWriter(new File(dir, "example.dot"))).close();
  }
}
