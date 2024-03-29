package com.matchup

class MatchController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [matchInstanceList: Match.list(params), matchInstanceTotal: Match.count()]
    }

    def create = {
        def matchInstance = new Match()
        matchInstance.properties = params
        return [matchInstance: matchInstance]
    }

    def save = {
        def matchInstance = new Match(params)
        if (matchInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'match.label', default: 'Match'), matchInstance.id])}"
            redirect(action: "show", id: matchInstance.id)
        }
        else {
            render(view: "create", model: [matchInstance: matchInstance])
        }
    }

    def show = {
        def matchInstance = Match.get(params.id)
        if (!matchInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'match.label', default: 'Match'), params.id])}"
            redirect(action: "list")
        }
        else {
            [matchInstance: matchInstance]
        }
    }

    def edit = {
        def matchInstance = Match.get(params.id)
        if (!matchInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'match.label', default: 'Match'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [matchInstance: matchInstance]
        }
    }

    def update = {
        def matchInstance = Match.get(params.id)
        if (matchInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (matchInstance.version > version) {
                    
                    matchInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'match.label', default: 'Match')] as Object[], "Another user has updated this Match while you were editing")
                    render(view: "edit", model: [matchInstance: matchInstance])
                    return
                }
            }
            matchInstance.properties = params
            if (!matchInstance.hasErrors() && matchInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'match.label', default: 'Match'), matchInstance.id])}"
                redirect(action: "show", id: matchInstance.id)
            }
            else {
                render(view: "edit", model: [matchInstance: matchInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'match.label', default: 'Match'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def matchInstance = Match.get(params.id)
        if (matchInstance) {
            try {
                matchInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'match.label', default: 'Match'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'match.label', default: 'Match'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'match.label', default: 'Match'), params.id])}"
            redirect(action: "list")
        }
    }
}
