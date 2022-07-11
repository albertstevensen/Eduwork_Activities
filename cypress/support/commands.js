// ***********************************************
// This example commands.js shows you how to
// create various custom commands and overwrite
// existing commands.
//
// For more comprehensive examples of custom
// commands please read more here:
// https://on.cypress.io/custom-commands
// ***********************************************
//
//
// -- This is a parent command --
// Cypress.Commands.add('login', (email, password) => { ... })
//
//
// -- This is a child command --
// Cypress.Commands.add('drag', { prevSubject: 'element'}, (subject, options) => { ... })
//
//
// -- This is a dual command --
// Cypress.Commands.add('dismiss', { prevSubject: 'optional'}, (subject, options) => { ... })
//
//
// -- This will overwrite an existing command --
// Cypress.Commands.overwrite('visit', (originalFn, url, options) => { ... })

Cypress.Commands.add('login', (username, password) =>{
    cy.clearLocalStorage
    cy.clearCookies

    cy.get('#user_login').clear()
    cy.get('#user_login').type(username)

    cy.get('#user_password').clear()
    cy.get('#user_password').type(password)

    cy.contains('Sign in').click()
})

Cypress.Commands.add('payBill', () =>{
    cy.get('#sp_payee').select('bofa')
        cy.get('#sp_account').select('5')
        cy.get('#sp_amount').clear()
        cy.get('#sp_amount').type('100')
        cy.get('#sp_date').type('2022-07-11')
        cy.get('#sp_amount').click()
        cy.get('#sp_description').clear()
        cy.get('#sp_description').type('testing')

        cy.get('#pay_saved_payees').click()
})