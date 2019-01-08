package com.begin.chapter5.AspectJ.expansion;

public aspect MessageWrapper {

    private String suffix;
    private String prefix;

    public String getSuffix() {
        return this.suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getPreffix() {
        return this.prefix;
    }

    public void setPreffix(String preffix) {
        this.prefix = preffix;
    }

    pointcut doWriting():
            execution(*
                    com.apress.prospring4.ch5.MessageWriter.writeMessage());
    before(): doWriting() {
        System.out.println(prefix);
    }
    after(): doWriting() {
        System.out.println(suffix);
    }
    }

