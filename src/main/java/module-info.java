module uk.ac.leeds.ccg.cg {
    requires transitive java.logging;
    requires java.desktop;
    requires uk.ac.leeds.ccg.generic;
    requires uk.ac.leeds.ccg.data;
    exports uk.ac.leeds.ccg.cg.core;
    exports uk.ac.leeds.ccg.cg.io;
    exports uk.ac.leeds.ccg.cg.process;
}