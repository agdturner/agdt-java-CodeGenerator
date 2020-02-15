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

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

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
     *
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

    /**
     * @param pw
     * @param fields
     * @param fieldTypes
     */
    public void printFieldDeclarations(PrintWriter pw, TreeSet<String> fields,
            HashMap<String, Integer> fieldTypes) {
        Iterator<String> ite = fields.iterator();
        while (ite.hasNext()) {
            String field = ite.next();
            int fieldType = fieldTypes.get(field);
            pw.print(getIndent(1));
            switch (fieldType) {
                case 0:
                    pw.println("protected String " + field + ";");
                    break;
                case 1:
                    pw.println("protected double " + field + ";");
                    break;
                case 2:
                    pw.println("protected int " + field + ";");
                    break;
                case 3:
                    pw.println("protected short " + field + ";");
                    break;
                case 4:
                    pw.println("protected byte " + field + ";");
                    break;
                default:
                    pw.println("protected boolean " + field + ";");
                    break;
            }
            pw.println();
        }
        //pw.flush();
    }

    /**
     * printFieldGetters
     *
     * @param pw PrintWriter
     * @param fields Fields
     * @param fieldTypes Field Types
     */
    public void printFieldGetters(PrintWriter pw, TreeSet<String> fields,
            HashMap<String, Integer> fieldTypes) {
        Iterator<String> ite = fields.iterator();
        while (ite.hasNext()) {
            String field = ite.next();
            int fieldType = fieldTypes.get(field);
            pw.print(getIndent(1));
            switch (fieldType) {
                case 0:
                    pw.println("public String get" + field + "() {");
                    break;
                case 1:
                    pw.println("public double get" + field + "() {");
                    break;
                case 2:
                    pw.println("public int get" + field + "() {");
                    break;
                case 3:
                    pw.println("public short get" + field + "() {");
                    break;
                case 4:
                    pw.println("public byte get" + field + "() {");
                    break;
                default:
                    pw.println("public boolean get" + field + "() {");
                    break;
            }
            pw.println(getIndent(2) + "return " + field + ";");
            pw.println(getIndent(1) + "}");
            pw.println();
        }
        pw.flush();
    }

    /**
     * printFieldInits
     *
     * @param pw PrintWriter
     * @param fields Fields
     * @param fieldTypes Field Types
     * @param v0
     */
    public void printFieldInits(PrintWriter pw, TreeSet<String> fields,
            HashMap<String, Integer> fieldTypes, HashMap<String, Byte> v0) {
        Iterator<String> ite = fields.iterator();
        while (ite.hasNext()) {
            String field = ite.next();
            int fieldType = fieldTypes.get(field);
            pw.print(getIndent(1));
            switch (fieldType) {
                case 0:
                    pw.println("protected final void init" + field + "(String s) {");
                    pw.println(getIndent(2) + "if (!s.trim().isEmpty()) {");
                    pw.println(getIndent(3) + field + " = s;");
                    break;
                case 1:
                    pw.println("protected final void init" + field + "(String s) {");
                    pw.println(getIndent(2) + "if (!s.trim().isEmpty()) {");
                    pw.println(getIndent(3) + field + " = Double.parseDouble(s);");
                    pw.println(getIndent(2) + "} else {");
                    pw.println(getIndent(3) + field + " = Double.NaN;");
                    break;
                case 2:
                    pw.println("protected final void init" + field + "(String s) {");
                    pw.println(getIndent(2) + "if (!s.trim().isEmpty()) {");
                    pw.println(getIndent(3) + field + " = Integer.parseInt(s);");
                    pw.println(getIndent(2) + "} else {");
                    pw.println(getIndent(3) + field + " = Integer.MIN_VALUE;");
                    break;
                case 3:
                    pw.println("protected final void init" + field + "(String s) {");
                    pw.println(getIndent(2) + "if (!s.trim().isEmpty()) {");
                    pw.println(getIndent(3) + field + " = Short.parseShort(s);");
                    pw.println(getIndent(2) + "} else {");
                    pw.println(getIndent(3) + field + " = Short.MIN_VALUE;");
                    break;
                case 4:
                    pw.println("protected final void init" + field + "(String s) {");
                    pw.println(getIndent(2) + "if (!s.trim().isEmpty()) {");
                    pw.println(getIndent(3) + field + " = Byte.parseByte(s);");
                    pw.println(getIndent(2) + "} else {");
                    pw.println(getIndent(3) + field + " = Byte.MIN_VALUE;");
                    break;
                default:
                    pw.println("protected final void init" + field + "(String s) {");
                    pw.println(getIndent(2) + "if (!s.trim().isEmpty()) {");
                    pw.println(getIndent(3) + "byte b = Byte.parseByte(s);");
                    if (v0.get(field) == null) {
                        pw.println(getIndent(3) + field + " = false;");
                    } else {
                        pw.println(getIndent(3) + "if (b == " + v0.get(field) + ") {");
                        pw.println(getIndent(4) + field + " = false;");
                        pw.println(getIndent(3) + "} else {");
                        pw.println(getIndent(4) + field + " = true;");
                        pw.println(getIndent(3) + "}");
                    }
                    break;
            }
            pw.println(getIndent(2) + "}");
            pw.println(getIndent(1) + "}");
            pw.println();
        }
        //pw.flush();
    }

        /**
     * Returns all the values common to s1, s2, s3, s4 and s5 and removes all
     * these common fields from s1, s2, s3, s4 and s5.
     *
     * @param s1
     * @param s2
     * @param s3 May be null.
     * @param s4 May be null.
     * @param s5 May be null.
     * @return
     * @Todo generalise
     */
    public TreeSet<String> getFieldsInCommon(TreeSet<String> s1,
            TreeSet<String> s2, TreeSet<String> s3, TreeSet<String> s4,
            TreeSet<String> s5) {
        TreeSet<String> r = new TreeSet<>();
        r.addAll(s1);
        r.retainAll(s2);
        if (s3 != null) {
            r.retainAll(s3);
        }
        if (s4 != null) {
            r.retainAll(s4);
        }
        if (s5 != null) {
            r.retainAll(s5);
        }
        return r;
    }

    protected HashMap<String, Byte> setCommonBooleanMaps(
            HashMap<String, Byte>[] v0ms, HashMap<String, Byte>[] v1ms,
            TreeSet<String>[] allFields, HashMap<String, Integer> fieldTypes) {
        TreeSet<String> fields = allFields[5];
        HashMap<String, Byte> v0m1 = new HashMap<>();
        HashMap<String, Byte> v1m1 = new HashMap<>();
        Iterator<String> ites0 = fields.iterator();
        while (ites0.hasNext()) {
            String field0 = ites0.next();
            if (fieldTypes.get(field0) == 5) {
                for (int w = 0; w < v0ms.length; w++) {
                    HashMap<String, Byte> v0m = v0ms[w];
                    HashMap<String, Byte> v1m = v1ms[w];
                    Iterator<String> ites1 = v0m.keySet().iterator();
                    while (ites1.hasNext()) {
                        String field1 = ites1.next();
                        if (field0.equalsIgnoreCase(field1)) {
                            byte v0 = v0m.get(field1);
                            Byte v1;
                            if (v1m == null) {
                                v1 = Byte.MIN_VALUE;
                            } else {
                                //System.out.println("field1 " + field1);
                                //System.out.println("field1 " + field1);
                                v1 = v1m.get(field1);
                                if (v1 == null) {
                                    v1 = Byte.MIN_VALUE;
                                }
                            }
                            Byte v01 = v0m1.get(field1);
                            Byte v11 = v1m1.get(field1);
                            if (v01 == null) {
                                v0m1.put(field1, v0);
                            } else {
                                if (v01 != v0) {
                                    // Field better stored as a byte than boolean.
                                    fieldTypes.put(field1, 4);
                                }
                                if (v11 == null) {
                                    v1m1.put(field1, v1);
                                } else {
                                    if (v1 != v11.byteValue()) {
                                        // Field better stored as a byte than boolean.
                                        fieldTypes.put(field1, 4);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return v0m1;
    }

    /**
     * Finds and returns those fields that are in common and those fields .
     * result[0] are the fields in common with all.
     *
     * @param headers
     * @return
     */
    public ArrayList<String>[] getFieldsList(ArrayList<String> headers) {
        ArrayList<String>[] r;
        int size = headers.size();
        r = new ArrayList[size];
        Iterator<String> ite = headers.iterator();
        int i = 0;
        while (ite.hasNext()) {
            r[i] = getFieldsList(ite.next());
            i++;
        }
        return r;
    }

    /**
     *
     * @param fields
     * @return
     */
    public TreeSet<String> getFields(String[] fields) {
        TreeSet<String> r = new TreeSet<>();
        r.addAll(Arrays.asList(fields));
        return r;
    }

    /**
     *
     * @param s
     * @return
     */
    public ArrayList<String> getFieldsList(String s) {
        ArrayList<String> r = new ArrayList<>();
        String[] split = s.split("\t");
        r.addAll(Arrays.asList(split));
        return r;
    }

}
