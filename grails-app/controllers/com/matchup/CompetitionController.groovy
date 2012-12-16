package com.matchup

class CompetitionController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)

        render (contentType:'text/json'){
            competitionInstanceList: Competition.list(params)
        }
    }

    def create = {
        def competitionInstance = new Competition()
        competitionInstance.properties = params
        competitionInstance.save(flush: true)
        return [competitionInstance: competitionInstance]
    }

    def save = {
        def competitionInstance = new Competition(params)
        if (competitionInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'competition.label', default: 'Competition'), competitionInstance.id])}"
            render (contentType:'text/json'){
                competition : competitionInstance
            }
        }
        else {
            redirect(action: "create", model: [competitionInstance: competitionInstance])
        }
    }

    def show = {
        def competitionInstance = Competition.get(params.id)
        if (!competitionInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'competition.label', default: 'Competition'), params.id])}"
            redirect(action: "list")
        }
        else {
            [competitionInstance: competitionInstance]
        }
    }

    def edit = {
        def competitionInstance = Competition.get(params.id)
        if (!competitionInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'competition.label', default: 'Competition'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [competitionInstance: competitionInstance]
        }
    }

    def update = {
        def competitionInstance = Competition.get(params.id)
        if (competitionInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (competitionInstance.version > version) {
                    
                    competitionInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'competition.label', default: 'Competition')] as Object[], "Another user has updated this Competition while you were editing")
                    render(view: "edit", model: [competitionInstance: competitionInstance])
                    return
                }
            }
            competitionInstance.properties = params
            if (!competitionInstance.hasErrors() && competitionInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'competition.label', default: 'Competition'), competitionInstance.id])}"
                redirect(action: "show", id: competitionInstance.id)
            }
            else {
                render(view: "edit", model: [competitionInstance: competitionInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'competition.label', default: 'Competition'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def competitionInstance = Competition.get(params.id)
        if (competitionInstance) {
            try {
                competitionInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'competition.label', default: 'Competition'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'competition.label', default: 'Competition'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'competition.label', default: 'Competition'), params.id])}"
            redirect(action: "list")
        }
    }
}
