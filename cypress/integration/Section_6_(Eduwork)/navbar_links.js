/// <reference types="cypress" />

describe('Assertion Login and Logout', () =>{
    before(() =>{
        cy.visit('http://zero.webappsecurity.com/index.html')
        cy.url().should('include', 'index.html')
    });

    it('should display online banking content', () =>{
        cy.contains('Online Banking').click()
        cy.url().should('include', 'online-banking.html')
        cy.get('h1').should('be.visible')

        //Perbedaan dari assertion yang ada di materi
        cy.contains('Pay bills easily').should('contain.text', 'Pay bills easily')
        cy.contains('Our Bank is trusted by over 1,000,000 customers world wide.').should('contain.text', 'Our Bank is trusted by over 1,000,000 customers world wide.')
        cy.get('#account_summary_link').should('contain.text', 'Account Summary')
        cy.contains('See all of your account balances at a glance.').should('contain.text', 'See all of your account balances at a glance.')
    });

    it('should display feedback content', () =>{
        cy.contains('Feedback').click()
        cy.url().should('include', 'feedback.html')
        cy.get('#feedback-title').should('contain.text', 'Feedback')
        cy.get('#name').should('be.visible')
    });

    it('should display homepage content', () =>{
        cy.contains('Zero Bank').click()
        cy.url().should('include', 'index.html')
        cy.get('img').should('be.visible')
    })
});