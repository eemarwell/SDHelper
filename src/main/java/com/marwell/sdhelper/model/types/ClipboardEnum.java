package com.marwell.sdhelper.model.types;

/**
 *
 * @author Eduardo Marwell
 */

public enum ClipboardEnum {
    //Chat
    SESSAOABERTA(
        "[code]<div role=\"alert\" class=\"outputmsg outputmsg_error notification notification-error\"><span class=\"outputmsg_text\">" +
        "Você tem uma sessão ativa no chat do Service Desk Américas.<br> <h3><strong><b>Deseja continuar?</b>" +
        "</strong></h3></span></div>[/code]"),
    SESSAOFECHADA(
        "[code]<div role=\"alert\" class=\"outputmsg outputmsg_error notification notification-error\"><span class=\"outputmsg_text\">" +
        "Sua sessão será encerrada porque não recebemos atividade nos últimos 6 minutos. Entre em contato novamente pelo chat ou pelo Portal do Service Desk Américas." +
        "<br></span></div>[/code]"),

    //Web tickets / Backlog
    STRIKE1(""),
    STRIKE2(""),
    STRIKE3("");

    private String clipboard;

    public String getClipboard() {
        return clipboard;
    }

    public void setClipboard(String clipboard) {
        this.clipboard = clipboard;
    }
    
    private ClipboardEnum(String clipboard) {
        this.clipboard = clipboard;
    }
}
