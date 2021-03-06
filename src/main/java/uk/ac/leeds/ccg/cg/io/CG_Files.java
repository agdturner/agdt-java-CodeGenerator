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
package uk.ac.leeds.ccg.cg.io;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import uk.ac.leeds.ccg.generic.io.Generic_Files;
import uk.ac.leeds.ccg.cg.core.CG_Strings;
import uk.ac.leeds.ccg.generic.io.Generic_Defaults;

/**
 * @author Andy Turner
 * @version 1.0.0
 */
public class CG_Files extends Generic_Files {
    
    /**
     * @param dir The directory.
     * @throws java.io.IOException If an IOException is encountered.
     */
    public CG_Files(Path dir) throws IOException {
        super(new Generic_Defaults(dir));
    }
    
    /**
     * @return {@code Paths.get(getDefaultDir().toString(), CG_Strings.s_CG)}.
     */
    public static Path getDefaultDir() {
        return Paths.get(getDefaultDir().toString(), CG_Strings.s_CG);
    }
}
