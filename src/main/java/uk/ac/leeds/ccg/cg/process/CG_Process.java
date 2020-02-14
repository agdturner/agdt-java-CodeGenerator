/*
 * Copyright 2019 Centre for Computational Geography, University of Leeds.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package uk.ac.leeds.ccg.cg.process;

import java.util.HashMap;

/**
 * CG_Process
 * 
 * @author Andy Turner
 * @version 1.0.0
 */
public class CG_Process {
    
    /**
     * For helping to ensure generated code is indented correctly.
     */
    public final HashMap<Integer, String> indents;
    
    /**
     * For representing the indent amount. The number of spaces for each indent.
     */
    public final String indent;
    
    /**
     * Creates a new instance
     */
    public CG_Process() {
        indents = new HashMap<>();
        indent = "    ";
    }
    
    /**
     * The number of spaces for {@code i} indents.
     * @param i The number of indents
     * @return A String of spaces for {@code i} indents.
     */
    public String getIndent(int i) {
        if (!indents.containsKey(i)) {
            String s = "";
            for (int j = 0; j < i; j++) {
                s += indent;
            }
            indents.put(i, s);
            return s;
        }
        return indents.get(i);
    }

}
