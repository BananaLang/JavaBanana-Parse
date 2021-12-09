package io.github.bananalang.parse.ast;

import io.github.bananalang.parse.ast.VariableDeclarationStatement.VariableDeclaration;

public final class FunctionDefinitionStatement extends StatementNode {
    public final String returnType, name;
    public final VariableDeclaration[] args;
    public final StatementList body;

    public FunctionDefinitionStatement(String returnType, String name, VariableDeclaration[] args, StatementList body, int row, int column) {
        super(row, column);
        this.returnType = returnType;
        this.name = name;
        this.args = args;
        this.body = body;
    }

    public FunctionDefinitionStatement(String returnType, String name, VariableDeclaration[] args, StatementList body) {
        this(returnType, name, args, body, 0, 0);
    }

    @Override
    protected void dump(StringBuilder output, int currentIndent, int indent) {
        output.append("FunctionDefinitionStatement{\n")
              .append(getIndent(currentIndent + indent))
              .append("returnType=");
        if (returnType == null) {
            output.append("var,\n");
        } else {
            output.append('"').append(returnType).append("\",\n");
        }
        output.append(getIndent(currentIndent + indent))
              .append("name=\"")
              .append(name)
              .append("\"\n")
              .append(getIndent(currentIndent + indent))
              .append("args=[");
        if (args.length > 0) {
            output.append('\n');
            for (int i = 0; i < args.length; i++) {
                if (i > 0) output.append(",\n");
                output.append(getIndent(currentIndent + 2 * indent));
                args[i].dump(output, currentIndent + 2 * indent, indent);
            }
            output.append('\n')
                  .append(getIndent(currentIndent + indent));
        }
        output.append("],\n")
              .append(getIndent(currentIndent + indent))
              .append("body=");
        body.dump(output, currentIndent + indent, indent);
        output.append('\n')
              .append(getIndent(currentIndent))
              .append('}');
    }

    @Override
    public String toString() {
        return string()
               .addIf(returnType != null, "returnType", returnType)
               .addIf(returnType == null, "returnType", (Object)"var")
               .add("name", name)
               .add("args", args)
               .add("body", body)
               .toString();
    }
}